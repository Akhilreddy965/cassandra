import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

public class CreateKeyspaceNetworkTopology {
    public static void main(String[] args) {
        // Connect to the Cassandra cluster
        try (CqlSession session = CqlSession.builder().build()) {

            // Define the CQL statement for keyspace creation
            String createKeyspaceQuery = "CREATE KEYSPACE IF NOT EXISTS my_keyspace " +
                                         "WITH replication = {'class': 'NetworkTopologyStrategy', " +
                                         "'datacenter1': 3, 'datacenter2': 2};";

            // Execute the query
            session.execute(SimpleStatement.newInstance(createKeyspaceQuery));

            System.out.println("Keyspace 'my_keyspace' created successfully using NetworkTopologyStrategy!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
