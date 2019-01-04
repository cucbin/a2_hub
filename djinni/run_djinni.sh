#! /usr/bin/env bash
set -eu
shopt -s nullglob

# Locate the script file.  Cross symlinks if necessary.
loc="$0"
while [ -h "$loc" ]; do
    ls=`ls -ld "$loc"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        loc="$link"  # Absolute link
    else
        loc="`dirname "$loc"`/$link"  # Relative link
    fi
done
base_dir=$(cd "`dirname "$loc"`" && pwd)

djinni_src_dir="$base_dir/../tools/src"

temp_out="$base_dir/djinni-output-temp"

in="$base_dir/example.djinni"

core_dir="$base_dir/../core/src/main/"
cpp_out="$core_dir/cpp/header"
jni_out="$core_dir/jni"
objc_out="$base_dir/generated-src/objc"
java_out="$core_dir/java/io/ioprint/core"

java_package="io.ioprint.core"

gen_stamp="$temp_out/gen.stamp"

if [ $# -eq 0 ]; then
    # Normal build.
    true
elif [ $# -eq 1 ]; then
    command="$1"; shift
    if [ "$command" != "clean" ]; then
        echo "Unexpected argument: \"$command\"." 1>&2
        exit 1
    fi
    for dir in "$temp_out" "$cpp_out" "$jni_out" "$java_out"; do
        if [ -e "$dir" ]; then
            echo "Deleting \"$dir\"..."
            rm -r "$dir"
        fi
    done
    exit
fi

# Build djinni
"$djinni_src_dir/build"

[ ! -e "$temp_out" ] || rm -r "$temp_out"
"$djinni_src_dir/run-assume-built" \
    --java-out "$temp_out/java" \
    --java-package $java_package \
    --java-generate-interfaces true \
    --ident-java-field mFooBar \
    \
    --cpp-out "$temp_out/cpp" \
    --cpp-namespace textsort \
    --ident-cpp-enum-type foo_bar \
    \
    --jni-include-cpp-prefix ../cpp/header/ \
    --jni-out "$temp_out/jni" \
    \
    --objc-out "$temp_out/objc" \
    --objcpp-out "$temp_out/objc" \
    --objc-type-prefix TXS \
    --objc-swift-bridging-header "TextSort-Bridging-Header" \
    \
    --idl "$in"

# Copy changes from "$temp_output" to final dir.

mirror() {
    local prefix="$1" ; shift
    local src="$1" ; shift
    local dest="$1" ; shift
    mkdir -p "$dest"
    rsync -r --delete --checksum --itemize-changes "$src"/ "$dest" | sed "s/^/[$prefix]/"
}

echo "Copying generated code to final directories..."
mirror "cpp" "$temp_out/cpp" "$cpp_out"
mirror "java" "$temp_out/java" "$java_out"
mirror "jni" "$temp_out/jni" "$jni_out"
#mirror "objc" "$temp_out/objc" "$objc_out"

rm -rf "$temp_out/cpp"
rm -rf "$temp_out/java"
rm -rf "$temp_out/jni"
rm -rf "$temp_out/objc"

date > "$gen_stamp"

echo "djinni completed."
