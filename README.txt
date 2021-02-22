raz.perry


=============================
=      File description     =
=============================
files in main package (filesprocessing):
DirectoryProcessor.java - This class is the main driver that creates parser object, get sections from it and
go over each section with the files in the source directory to filter, order and print the warnings and
results. It also catch the type 2 errors.
ToolBox.java - This is a static class with many static methods that calculate things for many classes in this
project.
argsException.java - This is an exception class of wrong args input.
WarningExceptions.java - This is an exception class of mistakes in the command files that handled (type 1
errors).


sub-package - parser:
ParserFile.java - This class is the parser of the commands file. Its create sections with filter and order
objects (by getting them from the factories), and add the sections the relevant warnings when needed. This is
the part that handled type 1 errors - they thrown from factories and catch here to create default objects and
updates warnings.
Section.java - This class holds filter and order objects 
ParserExceptions.java - This is an exception class of wrong commands file. It is type 2 error.
FilterException.java - This is an exception class of wrong filter sub-section in the command file. It is
inherited from ParserExceptions (so type 2 error).
OrderException.java - This is an exception class of wrong order sub-section in the command file. It is
inherited from ParserExceptions (so type 2 error).

sub-package - order:
Order.java - This is an interface of objects that knows how to sort list of files.
OrderFactory.java - This class is a factory of objects that implements Order interface.
abs.java - This class implements Order interface, so it has sort method. It sorting according to abs path,
by using ToolBox mergeSort method and the SortByAbs comparator.
size.java - This class implements Order interface, so it has sort method. It sorting according to the file
size, by using ToolBox mergeSort method and the SortBySize comparator.
type.java - This class implements Order interface, so it has sort method. It sorting according to the file
type, by using ToolBox mergeSort method and the SortByType comparator.
DecoratorOrder.java - This is an abstract class that represent decorators of objects which implements Order
interface.
DecoratorReverse.java - This class is a decorator that inherited from DecoratorOrder and it is reversing each
sorting of Order objects.
Types.java - enum of order types - abs, size, type.
sub-package - comparators:
SortByAbs.java - This is a comparator that compare files according to their absolute path.
SortBySize.java - This is a comparator that compare files according to their size.
SortByType.java - This is a comparator that compare files according to their type (extension).


sub-package - filter:
Filter.java - This is an interface of objects that knows how to filter files.
FilterFactory.java - This class is a factory of objects that implements Filter interface.
All.java - This class implements Filter interface, so it knows to filter files. It doesn't check anything on
the input file.
DecoratorFilter.java - This is an abstract class that represent decorators of objects which implements Filter
interface.
DecoratorNot.java - This class is a decorator that inherited from DecoratorFilter and it is returning the
opposite answer from the Filter objects.
Types.java - enums of filter types - greater_than, between, file, contains...

sub-package - size:
SizeFilters.java - This class is an abstract class that represent objects that knows to filter files and the
filter type is relevant to the file size (so the constructor get number and needed to convert bytes to kb).
Between.java - This class is inherited from SizeFilters, so it knows to filter files. It checks if the file
size is between the two input numbers.
Greater.java - This class is inherited from SizeFilters, so it knows to filter files. It checks if the file
size is greater than the input number.
Smaller.java - This class is inherited from SizeFilters, so it knows to filter files. It checks if the file
size is smaller than the input number.

sub-package = string:
StringValue.java - This class is an abstract class that represent objects that knows to filter files and the
filter type is constructs with a single string input (so all constructors are the same).
Contains.java - This class is inherited from StringValue, so it knows to filter files. It checks if the file
name contains the input value.
Executable.java - This class is inherited from StringValue, so it knows to filter files. It checks if the
file is executable.
File.java - This class is inherited from StringValue, so it knows to filter files. It checks if the file
name is equal to the input value.
Hidden.java - This class is inherited from StringValue, so it knows to filter files. It checks if the
file is hidden.
Prefix.java - This class is inherited from StringValue, so it knows to filter files. It checks if the input
value is the prefix of the file name.
Suffix.java - This class is inherited from StringValue, so it knows to filter files. It checks if the input
value is the suffix of the file name.
Writable.java - This class is inherited from StringValue, so it knows to filter files. It checks if the
file is writable.


=============================
=          Design           =
=============================
General:
I choose to leave the DirectoryProcessor as the main driver. It handles all type 2 errors (print error and
finish). The class itself is the one who reads the source directory (and checks if it is really directory
and not a file) and has a method which gets as input a Filter object and returns the list of files (without
inner directories) the passed that filter.
In the main First of all it checks the args validation (length) and than reads the files in the source
directory. After that it creates ParserFile object and by using it method that returns list of sections the
main save a list of section objects.
Than it goes over each section (using a loop) and do:
1. filter the files in the directory
2. order the files that returns from action 1
3. print the warnings of this section
4. print the ordered files list

Parser package:
As i said the main driver create ParserFile object. That object is responsible for understanding the commands
file according to the exercise information - it is the only part that knows how a section look like - first
line is "FILTER" then exactly one line of filter condition, then "ORDER" and then there could be at most one
line of order definition. If something is illegal it throw exception that catch in the main (type 2 errors).
When section reads successfully it adds to a data member (sections list) an object of the new valid section
(which holds Filter and Order objects and list of warnings). To create this object it first get Filter and 
Order objects from their factories. If factory thrown an exception the parser handles it and creating the
default objects instead (and add a new warning to the current section).

Filter/order packages:
Similar structure:
Both packages has an interface that define the relevant method (pass filter test/sort files list), and many
objects that implements that interface according to the exercise information.
Also I created for each of them a factory that creates those relevant objects. It is the only part in the
program that know the specific type of actions (single choice principle). It throw exceptions when the 
arguments aren't valid (for example - greeter_than#5 instead of greater_than#5), so it creates the objects
only with valid arguments (so there is no need of writing exceptions in the filter/order objects themselves).
Furthermore both packages has an abstract class of decorator that implements the interface and has classes
that inheriting from it as asked (in filter there is DecoratorNot and in Order there is DecoratorReverse.
Filters:
There are two sub-packages that contains abstract class and some sub-classes:
String package has StringValue abstract class that define default constructor for all filters that gets single
string as its arguments. The inheriting classes use the default constructor and implements the "isPass"
method (as define in the interface) according to the exercise information.
Size package has SizeFilters abstract class that define default constructor for all filters that gets single
double number as its arguments. The inheriting classes use the default constructor (between use constructor
that gets two arguments and use it for one of them) and implements the "isPass" method according to the
exercise information.

Orders:
As i said, each order type as a class that implements Order interface and the sort method. It using sortMerge
from the ToolBox and giving it relevant comparator. I wrote a relevant comparator to each order type and all
of them are in the comparators sub-package.

I think in that design i kept the open/closed and the single choice principles: if asked to add new filter
type or new order type, there is no need to change working methods in the program, all needed is to add the
type class and add to the relevant factory if section accordingly. Also if the arguments rules change, all
needed is to change one method in the parser.

=============================
=  Implementation details   =
=============================
ToolBox:
I wrote some static methods in this class for two reasons - one is to avoid code duplications when using same
method in different classes - for example the mergeSort methods. The second is making the code more readable
- for example the createSections method in the parser is very long and busy so i moved here some mass helper
methods that working on text (simplify the arguments) that has no important to be in the parserFile itself (it
doesn't need to save any data member there).

SortAlgo:
I implements the merge sort algorithm when adding to the input params a comparator. By that i use the if
section as a compare of the input comparator. In that implementation there is no code duplication and one
method is work for three different sort functions.

enums:
I created enums for each factory and for the parser to compare if the inputs are valid.

Exceptions:
I choose to create one exception for all type 1 errors, that because the handle of them was according to the
program and i it wasn't relevant which reason cause this specific warning.
For type 2 errors i create some exceptions. A super exception called ParserExceptions and their are two
exceptions who inherited from it - FilterException and OrderException. Both are type 1 errors of wrong
sub-section. General error in parsing is instance of the ParserExceptions and the relevant message is error
in all sub-section (without a specific sub-section name). Also there is an exception class for wrong args but
it used in the main file so it isn't with them in the parser package.

=============================
=    Answers to questions   =
=============================
1. My design explained in its section
2. As I wrote i choose to create hierarchy in the exceptions of type 2 errors - there are general errors in
the parser (thrown ParserExceptions) and there are specific sub-sections errors in the parser (so there are
two relevant sub-classes). In type 1 errors i didn't choose to work with sum different classes with hierarchy
becuase the handle and the message are general and same for all - i create one class with the message:
"warning in line: " and in the catch of that exception i had line counters so i created the relevant message
to the Section object.
3. As I said in the implementation, I choose to use merge sort algorithm that compare between the two file
using input comparator. So i create accordingly three comparators for each case (abs, type, size). In the
all program i use lists to save the files - first when checking if file isn't a directory and then when try
to filter the files (each time i couldn't know what size of array i should create, and linkedList as efficient
add runtime). So as i built the program i had to send the sort algorithm list of files and not an array.
I thought that in the avarage case it will be better than converting the list to array and the result array 
to list before and after each sort.