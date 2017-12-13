# CRUD Operation in MongoDb
<br/><br/>
## Program output 
[Success] Created connection
[Create] Total Number of documents in collection: 8
[Retrieve] Printing all documents using find operator: 
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead4e" }, "name" : "Coco", "Rating" : 96 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead4f" }, "name" : "Justice League", "Rating" : 40 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead50" }, "name" : "Wonder", "Rating" : 85 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead51" }, "name" : "Thor: Ragnarok", "Rating" : 92 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead52" }, "name" : "Dadd's Home 2", "Rating" : 18 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead53" }, "name" : "Lady Bird", "Rating" : 100 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead54" }, "name" : "The Star", "Rating" : 45 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead55" }, "name" : "Quest", "Rating" : 100 }
[Retrieve] Printing documents with Rating greater than 60: 
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead4e" }, "name" : "Coco", "Rating" : 96 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead50" }, "name" : "Wonder", "Rating" : 85 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead51" }, "name" : "Thor: Ragnarok", "Rating" : 92 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead53" }, "name" : "Lady Bird", "Rating" : 100 }
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead55" }, "name" : "Quest", "Rating" : 100 }
[Update] Printing updating documents: 
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead50" }, "name" : "Wonder Woman", "Rating" : 85 }
[Delete] Total Number of documents after 'deleteOne' operation:  7
[Delete] Total Number of documents after 'deleteMany' operation:  0
[Success] Closed Cursors
[Success] Closed connection

