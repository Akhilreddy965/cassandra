import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

public class CreateKeyspace {
    public static void main(String[] args) {
        // Connect to the Cassandra cluster
        try (CqlSession session = CqlSession.builder().build()) {
            
            // Define the keyspace creation CQL statement
            String createKeyspaceQuery = "CREATE KEYSPACE IF NOT EXISTS my_keyspace " +
                                         "WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 3};";

            // Execute the query
            session.execute(SimpleStatement.newInstance(createKeyspaceQuery));

            System.out.println("Keyspace 'my_keyspace' created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
