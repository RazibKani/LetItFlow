package id.codepresso.letitflow.data

import kotlinx.coroutines.flow.Flow
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

class FlowCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Flow::class.java) {
            return null
        }
        val observableType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableType = getRawType(observableType)
        require(rawObservableType == ApiResponse::class.java) { "type must be a resource" }
        require(observableType is ParameterizedType) { "resource must be parameterized" }
        val bodyType = getParameterUpperBound(0, observableType)
        return FlowCallAdapter<Any>(bodyType)
    }

    companion object {
        @JvmStatic
        fun create() = FlowCallAdapterFactory()
    }
}