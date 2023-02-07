How to load the F2CMVC source code into your IDE
-----------------------------------------

- Make a Java project named whatever: I used F2CMVC, but you can use
any name (make sure to include the JavaFX library in your project build path,
refer to instructions in https://openjfx.io/openjfx-docs/)
- Make a package named f2c.app and another package named f2c.view
under the project. (Different IDEs will have different ways of doing this.)
- Download the source code zip file
- Expand the zip file - it will produce folders f2c/app and f2c/view
- Drag and drop f2c.xml and F2CController.java from the f2c/view folder
into the f2c.view package in your IDE (or if your IDE does not allow drag
and drop, there should be a way to import these files into the package)
- Similarly, get the f2c/app/F2CApp.java file into the package f2c.app
- Run F2CApp, you should see the app window pop up. (Remember to set the
VM arguments correctly, and if in Eclipse, uncheck the Xstart checkbox.)
Again, refer to the instructions in https://openjfx.io/openjfx-docs/

