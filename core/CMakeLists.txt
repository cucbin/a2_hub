# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)
project(core)

# Android compile option with cpu
set(PLATFORM android)
set(CMAKE_ANDROID_API 19)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -latomic -lm -lz")

set(CORE_PATH ${PROJECT_SOURCE_DIR}/../)

# Adds definitions to the compiler command line for targets in the current directory
#add_definitions(-O3 -pthread -fexceptions -frtti)

add_library( core SHARED )

add_subdirectory (${CORE_PATH}/tools/support-lib/jni djinni)
add_subdirectory (${PROJECT_SOURCE_DIR}/src/main core_jni)
add_subdirectory (${PROJECT_SOURCE_DIR}/src/main/cpp core_impl)

# Specify libraries or flags to use when linking a given target and/or its dependents.
target_link_libraries( core

        "-Wl,--whole-archive"
        djinni
        core_jni
        "-Wl,--no-whole-archive"
        core_impl

        log
        )
