package com.justrunit

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import java.lang.management.ManagementFactory
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

@RestController
@RequestMapping("/")
class AppRestController {

    static final String UPTIME_DURATION_FORMAT = "d' day, 'H' hour, 'm' min, 's' sec'"

    int jokeRequestCount = 0

    @GetMapping("")
    String home(){
        String chuck = '<a href="/chuck">/chuck</a>'
        return """<p>HEY there random internet person... you've stumbled upon Roger's Container Demo!
                    Hit $chuck for a random Chuck Norris joke. I am not responsible for cleanness of the jokes. :)</p>
               """
    }

    @GetMapping("/chuck")
    Map chuckNorrisJoke(){

        jokeRequestCount++

        def jokeJson = new RestTemplate().getForObject('http://api.icndb.com/jokes/random', Object)

        Map mapResult = [:]

        //noinspection GrUnresolvedAccess
        mapResult.request = jokeRequestCount
        mapResult.joke = jokeJson?.value?.joke as String
        mapResult.jvmId = ManagementFactory.getRuntimeMXBean().getName()
        mapResult.jvmVersion = System.getProperty('java.version')
        mapResult.jvmVendor = ManagementFactory.getRuntimeMXBean().getVmVendor()
        mapResult.jvmUptime = getUptimeString(ManagementFactory.getRuntimeMXBean().getUptime())
        mapResult.publicIP = getPublicIP()
        mapResult.randomText = 'demo1'

        return mapResult
    }

    @GetMapping("/actors")
    List<Map> getActors() {

        List<Map> mapResult = []

        String url = "jdbc:mysql://container-demo-mysql.mysql.database.azure.com:3306/sakila?useSSL=true&requireSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
        Connection con = DriverManager.getConnection(url, "demo@container-demo-mysql", "33V0wpG5zm");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from actor");

        while (rs.next()) {
            Map map = [:]
            map.id = rs.getString("actor_id")
            map.firstName = rs.getString("first_name")
            map.lastName = rs.getString("last_name")
            mapResult << map
        }

        con.close();

        return mapResult
    }

    @SuppressWarnings("GrMethodMayBeStatic")
    String getUptimeString(long uptime) {
        return uptime.toString()
    }

    @SuppressWarnings("GrMethodMayBeStatic")
    String getPublicIP(){
        return new URL("http://checkip.amazonaws.com").text?.replace("\n", "")
    }

}
