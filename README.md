
# "Oracle Certified Professional, Java SE 8" training code

[![Join the chat at https://gitter.im/LuigiCortese/java-certification-ocp8](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/LuigiCortese/java-certification-ocp8?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Examples, resources and notes for "Oracle Certified Professional, Java SE 8" (OCPJP8) certification path, exam 1Z0-809.

~~ Currentrly Work in Progress ~~

# Certification Topics

The project is made up of 12 Maven modules, one for each macro topic as defined in the official list of [exam topics](http://education.oracle.com/pls/web_prod-plq-dad/db_pages.getpage?page_id=5001&get_params=p_exam_id:1Z0-809#tabs-2) in the Oracle website. Here the complete list:

1. **Java Class Design**
  * Implement encapsulation
  * Implement inheritance including visibility modifiers and composition
  * Implement polymorphism
  * Override hashCode, equals, and toString methods from Object class
  * Create and use singleton classes and immutable classes
  * Develop code that uses static keyword on initialize blocks, variables, methods, and classes
2. **Advanced Java Class Design**
  * Develop code that uses abstract classes and methods
  * Develop code that uses final keyword
  * Create inner classes including static inner class, local class, nested class, and anonymous inner class
  * Use enumerated types including methods, and constructors in an enum type
  * Develop code that declares, implements and/or extends interfaces and use the atOverride annotation.
  * Create and use Lambda expressions
3. **Generics and Collections**
  * Create and use a generic class
  * Create and use ArrayList, TreeSet, TreeMap, and ArrayDeque objects
  * Use java.util.Comparator and java.lang.Comparable interfaces
  * Collections Streams and Filters
  * Iterate using forEach methods of Streams and List
  * Describe Stream interface and Stream pipeline
  * Filter a collection by using lambda expressions
  * Use method references with Streams
4. **Lambda Built-in Functional Interfaces**
  * Use  the built-in interfaces included in the java.util.function package such as Predicate, Consumer, Function, and Supplier
  * Develop code that uses primitive versions of functional interfaces
  * Develop code that uses binary versions of functional interfaces
  * Develop code that uses the UnaryOperator interface
5. **Java Stream API**
  * Develop code to extract data from an object using peek() and map() methods including primitive versions of the map() method
  * Search for data by using search methods of the Stream classes including findFirst, findAny, anyMatch, allMatch, noneMatch
  * Develop code that uses the Optional class
  * Develop code that uses Stream data methods and calculation methods
  * Sort a collection using Stream API
  * Save results to a collection using the collect method and group/partition data using the Collectors class
  * Use flatMap() methods in the Stream API
6. **Exceptions and Assertions**
  * Use try-catch and throw statements
  * Use catch, multi-catch, and finally clauses
  * Use Autoclose resources with a try-with-resources statement
  * Create custom exceptions and Auto-closeable resources
  * Test invariants by using assertions
7. **Use Java SE 8 Date/Time API**
  * Create and manage date-based and time-based events including a combination of date and time into a single object using LocalDate, LocalTime, LocalDateTime, Instant, Period, and Duration
  * Work with dates and times across timezones and manage changes resulting from daylight savings including Format date and times values
  * Define and create and manage date-based and time-based events using Instant, Period, Duration, and TemporalUnit
8. **Java I/O Fundamentals**
  * Read and write data from the console
  * Use BufferedReader, BufferedWriter, File, FileReader, FileWriter, FileInputStream, FileOutputStream, ObjectOutputStream, ObjectInputStream, and PrintWriter in the java.iopackage.
9. **Java File I/O (NIO.2)**
  * Use Path interface to operate on file and directory paths
  * Use Files class to check, read, delete, copy, move, manage metadata of a file or directory
  * Use Stream API with NIO.2
10. **Java Concurrency**
  * Create worker threads using Runnable**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/threadandrunnable/waitnotify/App.java)****[[2]](10_JavaConcurrency/src/main/java/net/devsedge/lockandcondition/lockawaitnotify/App.java)**, Callable**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/executorservice/withcallable/App.java)** and use an ExecutorService**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/executorservice/withrunnable/App.java)** to concurrently execute tasks
  * Identify potential threading problems among deadlock, starvation, livelock, and race conditions
  * Use synchronized keyword and java.util.concurrent.atomic package to control the order of thread execution
  * Use java.util.concurrent collections**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/concurrentcollections/concurrenthashmap/App.java)** and classes including CyclicBarrier**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/cyclicbarrier/basic/App.java)** and CopyOnWriteArrayList**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/copyonwritearraylist/basic/App.java)**
  * Use parallel Fork/Join**[[1]](10_JavaConcurrency/src/main/java/net/devsedge/forkjoin/withaction/App.java)****[[2]](10_JavaConcurrency/src/main/java/net/devsedge/forkjoin/withtask/App.java)** Framework
  * Use parallel Streams including reduction, decomposition, merging processes, pipelines and performance.
11. **Building Database Applications with JDBC**
  * Describe the interfaces that make up the core of the JDBC API including the Driver, Connection, Statement, and ResultSet interfaces and their relationship to provider implementations
  * Identify the components required to connect to a database using the DriverManager class including the JDBC URL
  * Submit queries and read results from the database including creating statements, returning result sets, iterating through the results, and properly closing result sets, statements, and connections
12. **Localization**
  * Read and set the locale by using the Locale**[[1]](12_Localization/src/main/java/net/devsedge/locale/basics/App.java)** object
  * Create and read a Properties**[[1]](12_Localization/src/main/java/net/devsedge/resourcefile/basics/App.java)** file
  * Build a resource bundle**[[1]](12_Localization/src/main/java/net/devsedge/resourceboundle/fromfile/App.java)** for each locale and load a resource bundle in an application
