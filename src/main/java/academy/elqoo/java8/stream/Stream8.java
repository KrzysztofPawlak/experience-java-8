package academy.elqoo.java8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
         return numbers.stream().map(Math::sqrt).mapToInt(Double::intValue).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
        return user.stream().map(User::getAge).collect(toList());
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream().map(User::getAge).distinct().collect(toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return Math.toIntExact(users.stream().filter(u -> u.getAge() > 25).count());
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream().map(String::toUpperCase).collect(toList());
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream().mapToInt(i -> i).sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream().map(s -> s.split(" ")[0]).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
    }

    public static String separateNamesByComma(List<User> users){
        return users.stream().map(User::getName).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream().map(User::getAge).max(Integer::compare).orElse(0);
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().map(User::getAge).min(Integer::compare).orElse(0);
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream().collect(partitioningBy(User::isMale));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream().collect(groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        return users.stream().collect(groupingBy(User::isMale, groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream().collect(groupingBy(User::isMale, counting()));
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream().anyMatch(u -> u.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream().noneMatch(u -> u.getAge() == age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream().filter(u -> u.getName() == name).findAny();
    }

    public static List<User> sortByAge(List<User> users){
        return users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        throw new NotImplementedException();
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        return new Random().ints(10).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static User findOldest(List<User> users){
        return users.stream().max(Comparator.comparingInt(User::getAge)).orElse(null);
    }

    public static int sumAge(List<User> users){
        return users.stream().map(User::getAge).reduce(0, Integer::sum);
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        return users.stream().mapToInt(User::getAge).summaryStatistics();
    }

}
