project (core_impl)

file (GLOB SRC_FILES ${PROJECT_SOURCE_DIR}/impl/*.cpp)

add_library (core_impl
        STATIC
        ${SRC_FILES}
        )