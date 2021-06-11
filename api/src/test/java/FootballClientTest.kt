import com.andromite.api.data.FootballClient
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FootballClientTest {

    @Test
    fun `GET football squad`(){
        runBlocking {
            val squads = FootballClient.api.getSquads("ligaasdf")
            assertNotNull(squads.body())
        }
    }

}