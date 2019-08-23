Module Declaration:-
  - file should be name as `module-info.java`.
  - `module-info.java` keys and its usage.   
  
 
| Key | usage |  
| - | - |      
| `require` | dependencies.   |
| `require static` | dependencies are required at compile time, not runtime. |
| `require transitive` | exports dependencies too for users. |
| `exports` | expose the list of packages for public accessibility. |
| `exports to` | expose packages to list of specific modules only. |
| `opens` | can access through reflection. |
| `opens to` | can access through reflection by only specific modules. |
| `uses` |  specify serives used by current module. |
| `privides with` | provides implement for specific interface or abstract class. |

Note:-
- unnamed packages were not allowed in modular system.
   
Helloworld modular example:-   

```
package com.learning.alpha;

public class Alpha {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to java modularity!!!");
    }
}

```

compile java source code to bytecode:-   

```
javac -d classes com/learning/alpha/Alpha.java module-info.java

```   

create jar from compiled class file:-   

```
jar --create --file jars/modulebasics.jar --main-class com.learning.alpha.Alpha -C classes .

```   

run jar normaly:-   

```

java -jar jars/modulebasics.jar
Hello, Welcome to java modularity!!!

```

run as modular jar:-   

```

java --module-path jars/modulebasics.jar --module com.learning.alpha    
Hello, Welcome to java modularity!!!

```
A modular jar can run as like normal jar.
