Module Declaration:-
  - file should be name as module-info.java
  - module-info.java will look like
      module <modulename> {
      
        | require | module dependencies. |
        |  ------ |  --------------------  |
        | require static | module required at compile time, not runtime. |
        | require transitive | exports dependencies too. |
        | exports | expose the list of packages for public accessibility. |
        | exports to | expose packages to list of modules only. |
        | opens | can access through reflection. |
        | opens to | can access through reflection by only specific modules. |
        | uses |  specify interface or abstract class for other modules to implement. |
        | privides with | provides implement for specific interface or abstract class. |
        
      }
        
