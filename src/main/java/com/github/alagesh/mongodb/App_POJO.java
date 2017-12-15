package com.github.alagesh.mongodb;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Updates.set;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * 
 * Perform CRUD operations on MongoDB | Movies Collection using POJO
 * 1. Create - Insert  movie(s) using Movie POJO
 * 2. Retrieve - Print All movie(s) & Print movies by Condition 
 * 3. Update - Update movie by Condition  
 * 4. Delete - DeleteOne movie by condition & Truncate collection    
 * 
 * @author Azhakesan Thangamuthu
 * @version 1.0
 */

public class App_POJO {
	
	
	public static void main(String[] args) {
		
		
		MongoClient mongoClient = null;
  
		/*
    	 * Step 1: Create connection between Java Application -> MongoDB Server using MongoClient
    	 * P.s: Ideally the server details and database should be stored in appserver / config
    	 * Check for right compatible java driver  
    	 * https://docs.mongodb.com/ecosystem/drivers/driver-compatibility-reference/#reference-compatibility-mongodb-java
    	 * For MongoDb3.4  -> Using latest driver Version 3.6
    	 */
    	try {
    		
    	mongoClient = new MongoClient("localhost" , 27017);    		
     	System.out.println("[Success] Created connection");
     		
    	
    	 // create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        // get handle to "mydb" database
        MongoDatabase db = mongoClient.getDatabase("mydb").withCodecRegistry(pojoCodecRegistry);

    		
    	//MongoCollection<Document> collection = db.getCollection("movies"); 
    	// Instead of Document, Map to POJO Object - Movie
    	MongoCollection<Movie> collection = db.getCollection("mydb", Movie.class);
    	
    	//Insert Data to Collection    	
    	// Random data from Rotten Tomatoes and doesn't reflect my personal review.
		 
		collection.insertOne(new Movie("Coco",96));
		collection.insertOne(new Movie("Justice League",40));
		collection.insertOne(new Movie("Wonder",85));
		collection.insertOne(new Movie("Thor: Ragnarok",92));
		collection.insertOne(new Movie("Dadd's Home 2",18));
		collection.insertOne(new Movie("Lady Bird",100));
		collection.insertOne(new Movie("The Star",45));		
		collection.insertOne(new Movie("Quest",100));
		
		System.out.println("[Create] Total Number of documents in collection: " + collection.count());
		
        
		
		
		  Block<Movie> printBlock = new Block<Movie>() {	            
	            public void apply(final Movie movie) {
	                System.out.println(movie);
	            }
	        };
	   	 System.out.println("[Retrieve] Printing documents with Rating greater than 90: ");
	     //Retrieve all documents meeting condition, rating greater than 90
		collection.find(gt("rating", 90)).forEach(printBlock);
		 
			//Update Document 
		UpdateResult updateResult = collection.updateOne(eq("name", "Wonder"), set("name", "Wonder Woman"));
		System.out.println("[Update]: Records modified : "+updateResult.getModifiedCount());

		 
		 	// Delete One
	        collection.deleteOne(eq("name", "Coco"));
	        System.out.println("[Delete] Total Number of documents after 'deleteOne' operation:  " + collection.count());
	        
	        // Delete Many
	        DeleteResult deleteResult = collection.deleteMany(new Document());	        
	    	System.out.println("[Delete] Total Number of documents after 'deleteMany' operation:  " + collection.count());
    		
    	}catch(Exception e) {
    		//Check for exceptions
    		System.out.println("[Exception] "+e.getMessage());
    		
    	}finally {
    		
       		//Close Connections
    		mongoClient.close();
    		System.out.println("[Success] Closed connection");
    		
    	}
		
	}

}
