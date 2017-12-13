package com.github.alagesh.mongodb;


import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Updates.set;

/**
 * Perform CRUD operations on MongoDB | Movies Collection
 * 1. Create - Insert  movie(s)
 * 2. Retrieve - Print All movie(s) & Print movies by Condition 
 * 3. Update - Update movie by Condition  
 * 4. Delete - DeleteOne movie by condition & Truncate collection    
 * 
 * @author Azhakesan Thangamuthu
 * @version 1.0
 */

public class App 
{
    public static void main( String[] args )
    {
      
    	MongoClient mongoClient = null;
    	MongoCursor<Document> rs_all = null;
    	MongoCursor<Document> rs_condition = null;
    	MongoCursor<Document> rs_update = null;
    	
    	try {
    		
    		/*
        	 * Step 1: Create connection between Java Application -> MongoDB Server using MongoClient
        	 * P.s: Ideally the server details and database should be stored in appserver / config
        	 * Check for right compatible java driver  
        	 * https://docs.mongodb.com/ecosystem/drivers/driver-compatibility-reference/#reference-compatibility-mongodb-java
        	 * For MongoDb3.4  -> Using latest driver Version 3.6
        	 */
    	
    		mongoClient = new MongoClient("localhost" , 27017);    		
     		System.out.println(" [Success] Created connection");
     		
    		MongoDatabase db = mongoClient.getDatabase("mydb");
    		
    		MongoCollection<Document> collection = db.getCollection("movies");    		    		
    		
    		
    		// Random data from Rotten Tomatoes and doesn't reflect my personal review.
    		 
    		collection.insertOne(new Document()    				
    				.append("name", "Coco")
    				.append("Rating", 96)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "Justice League")
    				.append("Rating", 40)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "Wonder")
    				.append("Rating", 85)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "Thor: Ragnarok")
    				.append("Rating", 92)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "Dadd's Home 2")
    				.append("Rating", 18)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "Lady Bird")
    				.append("Rating", 100)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "The Star")
    				.append("Rating", 45)
    				);
    		
    		collection.insertOne(new Document()
    				.append("name", "Quest")
    				.append("Rating", 100)
    				);
    		
    		
    		 System.out.println(" [Create] Total Number of documents in collection: " + collection.count());
    		 
    		 //Retrieve all documents
    		 
    		 rs_all = collection.find().iterator();
    		 System.out.println("[Retrieve] Printing all documents using find operator: ");
    		 while (rs_all.hasNext()) {
                 System.out.println(rs_all.next().toJson());
             }
    		 
    		 //Retrieve all documents meeting condition, rating greater than 60
    		 
    		 rs_condition = collection.find(gt("Rating",60)).iterator();
    		 System.out.println("[Retrieve] Printing documents with Rating greater than 60: ");
    		 while (rs_condition.hasNext()) {
                 System.out.println(rs_condition.next().toJson());
             }
    		 
    		 //Update one document - Change name from Wonder to Wonder Woman
    		 collection.updateOne(eq("name", "Wonder"), set("name", "Wonder Woman"));
    		 rs_update = collection.find(eq("name","Wonder Woman")).iterator();
    		 System.out.println("[Update] Printing updating documents: ");
    		 while (rs_update.hasNext()) {
                 System.out.println(rs_update.next().toJson());
             }
    		 
    		//Delete one document
    		 collection.deleteOne(eq("name", "The Star"));
    		
    	    System.out.println("[Delete] Total Number of documents after 'deleteOne' operation:  " + collection.count());
    		 
    		 //Truncate All documents in movies collection
    		collection.deleteMany(new Document());
    		
    		System.out.println("[Delete] Total Number of documents after 'deleteMany' operation:  " + collection.count());
    		
    		
    	}catch(Exception e){
    		//Check for exceptions
    		System.out.println("[Exception] "+e.getMessage());
    		
    	}finally {
    		
    		//Close cursors
    		rs_all.close();
    		rs_condition.close();
    		rs_update.close();
    		System.out.println("[Success] Closed Cursors");
    		//Close Connections
    		mongoClient.close();
    		System.out.println("[Success] Closed connection");
    	}
    	
    }
 
}
