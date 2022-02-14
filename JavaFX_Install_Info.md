Installing JavaFX:
	We all need JavaFX installed on our computers for the project to be able to compile on your end.
	If you are working on GUI visual layout then you will also need to install SceneBuilder.
	
	Install JavaFX w/ Eclipse: https://www.youtube.com/watch?v=_7OM-cMYWbQ
	Link SceneBuilder w/ Eclipse: https://www.youtube.com/watch?v=yngO5WwfZCY
	
	I recommend watching both before doing anything.
	
Extra install notes:
	The Install location for JavaFX was set up as C:\Program Files\Java\Extenstions
	
	Eclipse needs a few things linked when you put the project in your workspace.
	
	In the project's Build path > Libraries > Modulepath the three Libraries must have the jar file(s) linked
	
	1. JavaFX - In your javaFX install add all the jar files in its lib folder (videos show how)
	
	2. JavaFX SDK - This is the exstention that you can get from the eclipse marketplace.
		Go to help > marketplace an search javaFX, you need an exstention called e(fx)clipse
	
	3. JRE System Library- I made the project in JavaSE-12 (jdk-12.0.2) if you don't have that installed get it.
		Then select this module and click the edit on the right. you can then select the right javaSE version.
