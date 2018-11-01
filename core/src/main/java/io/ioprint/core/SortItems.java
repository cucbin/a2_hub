// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from example.djinni

package io.ioprint.core;

import java.util.concurrent.atomic.AtomicBoolean;

public interface SortItems {
    /** For the iOS / Android demo */
    public void sort(SortOrder order, ItemList items);

    public static SortItems createWithListener(TextboxListener listener)
    {
        return CppProxy.createWithListener(listener);
    }

    /** For the localhost / command-line demo */
    public static ItemList runSort(ItemList items)
    {
        return CppProxy.runSort(items);
    }

    static final class CppProxy implements SortItems
    {
        private final long nativeRef;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);

        private CppProxy(long nativeRef)
        {
            if (nativeRef == 0) throw new RuntimeException("nativeRef is zero");
            this.nativeRef = nativeRef;
        }

        private native void nativeDestroy(long nativeRef);
        public void _djinni_private_destroy()
        {
            boolean destroyed = this.destroyed.getAndSet(true);
            if (!destroyed) nativeDestroy(this.nativeRef);
        }
        protected void finalize() throws java.lang.Throwable
        {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override
        public void sort(SortOrder order, ItemList items)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_sort(this.nativeRef, order, items);
        }
        private native void native_sort(long _nativeRef, SortOrder order, ItemList items);

        public static native SortItems createWithListener(TextboxListener listener);

        public static native ItemList runSort(ItemList items);
    }
}
