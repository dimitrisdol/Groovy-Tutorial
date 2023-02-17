class GroovyTutorial{
  static void main(String[] args) {

    /*
    //Person class example

    Person johndoe = new Person()
    johndoe.setFirstName("John")
    johndoe.setLastName("Doe")
    johndoe.setAge(55)

    Person maryHill = new Person("Mary", "Hill", 30)
    Person thomasMarks = new Person("Thomas", "Marks", 89)

     */

    /*

    //printing getters

    println person
    println person.getFullName()
    println person.getAge()

  // If statement

    if (person.getAge() >= 45 && person.getAge() <= 65) {
      println person.getFullName() + " is middle aged."
    } else {
      println person.getFullName() + " is " + person.getAge() + " years old"
    }

    // Variables and iteration

    def persons = [person, new Person(firstName: "Mary", lastName: "Hill", age: 40)]

    for (Person p : persons) {
        println p.getFullName()
    }

    // Try and catch method

    try {
      person.getFirstName().toLong()
    } catch(NumberFormatException e) {
      assert e instanceof NumberFormatException
      println("Cannot convert a String into a Long idiot!")

      println person.getFirstName().dropRight(2)
    }
    */

    /*
    // Calculator execution

    Calculator calculator = new Calculator()
    println "Here is an addition test of 12 and 23: " + calculator.addition(12,23)
    println "Here is a subtraction example of 25 and 12: " + calculator.subtraction(25,12)
    println "Also a multiplication example of 10 and 4: " + calculator.multiplication(10,4)
    println "And finally the division of 25 with 11: " + calculator.division(25,11)
    print "Error checking with division by 0: " + calculator.division(213, 0)

     */

    /*
    // Closures

    // Create Closure
    Closure personToString = { Person person -> println person.toString() }
    //personToString(johndoe)

    // Pass Closure
    handlePerson(personToString, johndoe)

    //Close full name
    Closure personFullName = { Person person ->
      println person.firstName + " " + person.lastName
    }
    handlePerson(personFullName, johndoe)
  }

  static void handlePerson(Closure c, Person p) {
    if (p == null) {
      throw new RuntimeException("A person instane cannot be null")
    }
    c(p)
    */

    /*
    // Create a list of persons

    def allPersons = [johndoe,maryHill,thomasMarks]

    //making sure lists is as is

    assert allPersons instanceof  List
    assert allPersons.size() ==  3
    assert allPersons[2] == thomasMarks

    //iteration

    allPersons.each {
      println it
    }

    //iteration with index

    allPersons.eachWithIndex { Person entry, int i ->
      println i + ": " + entry
    }

    //Filtering a specific element
    allPersons.find{ it.lastName == "Hill"} == maryHill

    //Transforming elements into something else
    allPersons.collect {it.age <=30} == [false,true,false]

    //Sortin elements based on a criterion
    allPersons.sort {it.age} == [maryHill,johndoe,thomasMarks]

    //Testing
    println allPersons.sort {it.age}
    println allPersons.collect {
      it.age <= 30
    } */

    /*
    // Read file
    File file = new File("resources/john-doe-info.txt")
    println file.getText('UTF-8')

    //Iterate over file

    file.eachLine { line, no->
      if (no == 1) {
        johndoe.setFirstName(line)
      } else if ( no ==2) {
        johndoe.setLastName(line)
        } else if (no ==3) {
        johndoe.setAge(line.toInteger())
      } else {
        throw new RuntimeException("A person text file is only 3 lines now")
      }
    }
    */

    /*
    //Writing files
    File textFile = new File("resources/mary-hill.txt")
    textFile.withWriter {writer ->
      writer.writeLine("Mary")
      writer.writeLine("Hill")
      writer.writeLine("30")
    }

    // Appending contents to file

    textFile.append("1")
    textFile << "2"

    // Serializing an object to a file
    File binFile = new File("resources/thomas-marks.bin")
    binFile.withObjectOutputStream { out ->
      out.writeObject(thomasMarks)
    }

     */

    // Complex  Challenge.

    // This Challenge is as follows.
    // Read all lines of every file found in the resources directory.
    // Capture all numbers in a List while omitting other entries.
    // Determine highest number in List and print it.
    // Add all numbers in List and print sum.

    // Reading all files in the directory resources/
    File dir = new File("resources/")

    // Creating a List of all the files in the directory and
    // instantiating the List of numbers.

    def files = dir.listFiles()
    def numList = []

    // Iterate through every file and split each line with the empty space as regex
    // For every word split by the regex call the checkNumber function to see
    // if the word is indeed a number. If yes, then add it to the number List.
    for (File  f : files) {
     //println f   # Debugging
      f.withReader {it.splitEachLine(" ") {
        //println it            # Debugging
        for (String word: it){
         if(checkNumber(word))
          numList << word.toInteger()
        }
       }
      }
    }

    // Now sort the list and print the highest number.
    numList.sort()
    //println numList           # Debugging
    println "The highest number in all files is: " + numList.last()

    // Now add the list and print the sum of all numbers.
    int listSum = numList.sum() as int
    println "The sum of the total numbers appearing in the files is: " + listSum
  }

  // This function receives as input every word of the files.
  // Then it checks if that word is an Integer. If yes it returns true
  // else it returns false.
  static boolean checkNumber(String word) {
    try {
      int tmp = word.toInteger()
      return true
    } catch (NumberFormatException e) {
      assert e instanceof NumberFormatException
      //println "Not a number"  # Debugging
      return false
    }
  }
}