package network

import android.content.Context
import com.example.appmovil.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.security.KeyStore
import java.security.SecureRandom
import java.util.concurrent.TimeUnit
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext

var BASE_URL="http://orion.atc.uniovi.es/"

interface RestApiService {
    @GET("~arias/json/DondeComer.json")
    suspend fun getStatusInfo(): ArrayList<String>
}


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object RestApi {
    val retrofitService: RestApiService by lazy {
        retrofit.create(RestApiService::class.java)
    }
}
/*
object ServiceGenerator {

    /**
     * Generates an OkHttpClient with our trusted CAs
     * to make calls to a service which requires it.
     *
     * @param context the context to access our file.
     * @return OkHttpClient with our trusted CAs added.
     */
    private fun generateSecureOkHttpClient(context: Context): OkHttpClient {
        // Create a simple builder for our http client, this is only por example purposes
        var httpClientBuilder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)

        // Here you may wanna add some headers or custom setting for your builder

        // Get the file of our certificate
        var caFileInputStream = context.resources.openRawResource(R.raw.gijon_es)

        // We're going to put our certificates in a Keystore
        val keyStore = KeyStore.getInstance("PKCS12")
        keyStore.load(caFileInputStream, "my file password".toCharArray())

        // Create a KeyManagerFactory with our specific algorithm our our public keys
        // Most of the cases is gonna be "X509"
        val keyManagerFactory = KeyManagerFactory.getInstance("X509")
        keyManagerFactory.init(keyStore, "my file password".toCharArray())

        // Create a SSL context with the key managers of the KeyManagerFactory
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(keyManagerFactory.keyManagers, null, SecureRandom())

        //Finally set the sslSocketFactory to our builder and build it
        return httpClientBuilder
            .sslSocketFactory(sslContext.socketFactory)
            .build()
    }

    /**
     * Example method to show the usage of the OkHttpClient
     *
     * @param context the context to access our file.
     * @return Retrofit service
     */
    fun generateService(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://development.myapi.com/")
            .client(generateSecureOkHttpClient(context))
            .build()
    }

}*/