# WordFrequencyCounter
An REST-API that count the occurences of words in a string and returns the ten most frequent words and the occurences of them.

### Getting started
Download the file as a zip-file or "clone git-repository"
Choose the preferred IDE to open the projekt. Make sure the IDE supports java 17 or higher
Run the project in the IDE and make a POST-Request to the API using either curl or some program like Postman
The endpoint of the API is /count and it runs on localhost:8080


### Example
curl http://localhost:8080/count -X POST -d "Golden slumbers kiss your eyes Smiles awake you when you rise Sleep pretty wantons do not cry 
And I will sing a lullaby Rock them rock them lullaby" -H"Content-Type: plain/text"
