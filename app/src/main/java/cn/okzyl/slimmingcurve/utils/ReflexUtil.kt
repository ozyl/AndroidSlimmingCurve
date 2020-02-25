package cn.okzyl.slimmingcurve.utils

import java.lang.reflect.ParameterizedType

class ReflexUtil {
    companion object{
        fun <T> getGenericClass(any: Any,position:Int=0): Class<T> {

            val pt =
                any.javaClass.genericSuperclass as ParameterizedType
            @Suppress("UNCHECKED_CAST")
            return pt.actualTypeArguments[position] as Class<T>
        }
    }
}