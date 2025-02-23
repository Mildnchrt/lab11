package student;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.*;


/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting birthdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> compare) {
		students.stream().filter( filter ).sorted( compare ).forEach( action );
	}
	
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		List<Student> students = Registrar.getInstance().getStudents();
		StudentApp app = new StudentApp();
		Consumer<Student> birthday = (s) -> System.out.printf("%s %s will have birthday on %d %s\n" , s.getFirstname(), s.getLastname(), s.getBirthdate().getDayOfMonth(), s.getBirthdate().getMonth());
		Predicate<Student> twoWeek = (s) -> s.getBirthdate().getDayOfYear() <= localDate.getDayOfYear()+14 && s.getBirthdate().getDayOfYear() >= localDate.getDayOfYear();
		Predicate<Student> monthBirthTest = (s) -> s.getBirthdate().getMonthValue() == localDate.getMonthValue();
		Comparator<Student> byName = (a, b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth();
		app.filterAndPrint( students, twoWeek, birthday, byName);
	}
}
