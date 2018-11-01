project (core_jni)

file (GLOB SRC_FILES ${PROJECT_SOURCE_DIR}/jni/*.cpp)

include_directories(${CORE_PATH}/tools/support-lib/jni/)

add_library (core_jni
        STATIC
        ${SRC_FILES}
        )