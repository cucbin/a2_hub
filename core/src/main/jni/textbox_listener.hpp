// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from example.djinni

#pragma once

#include "../cpp/header/textbox_listener.hpp"
#include "djinni_support.hpp"

namespace djinni_generated {

class TextboxListener final : ::djinni::JniInterface<::textsort::TextboxListener, TextboxListener> {
public:
    using CppType = std::shared_ptr<::textsort::TextboxListener>;
    using CppOptType = std::shared_ptr<::textsort::TextboxListener>;
    using JniType = jobject;

    using Boxed = TextboxListener;

    ~TextboxListener();

    static CppType toCpp(JNIEnv* jniEnv, JniType j) { return ::djinni::JniClass<TextboxListener>::get()._fromJava(jniEnv, j); }
    static ::djinni::LocalRef<JniType> fromCppOpt(JNIEnv* jniEnv, const CppOptType& c) { return {jniEnv, ::djinni::JniClass<TextboxListener>::get()._toJava(jniEnv, c)}; }
    static ::djinni::LocalRef<JniType> fromCpp(JNIEnv* jniEnv, const CppType& c) { return fromCppOpt(jniEnv, c); }

private:
    TextboxListener();
    friend ::djinni::JniClass<TextboxListener>;
    friend ::djinni::JniInterface<::textsort::TextboxListener, TextboxListener>;

    class JavaProxy final : ::djinni::JavaProxyHandle<JavaProxy>, public ::textsort::TextboxListener
    {
    public:
        JavaProxy(JniType j);
        ~JavaProxy();

        void update(const ::textsort::ItemList & items) override;

    private:
        friend ::djinni::JniInterface<::textsort::TextboxListener, ::djinni_generated::TextboxListener>;
    };

    const ::djinni::GlobalRef<jclass> clazz { ::djinni::jniFindClass("io/ioprint/core/TextboxListener") };
    const jmethodID method_update { ::djinni::jniGetMethodID(clazz.get(), "update", "(Lio/ioprint/core/ItemList;)V") };
};

}  // namespace djinni_generated
