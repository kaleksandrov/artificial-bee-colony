package bg.metaheuristic.abc.util;

/**
 * Holds application common constants
 * 
 * @author Kiril Aleksandrov
 * 
 */
public interface Constants {

	/* Logger */

	String LOG_RULE_THICK = "===========================";

	String LOG_RULE_THIN = "----------------------";

	/* Resource generation */

	int LIST_MIN_SIZE = 1000;
	int LIST_MAX_SIZE = 100000;
	int LIST_AVERAGE_SIZE = 10000;

	int ENVIRONMENT_MIN_SIZE = 500;
	int ENVIRONMENT_MAX_SIZE = 1000;

	/* Persisting */

	String FIELD_SEPARATOR = "\t";
}
