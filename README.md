# CRUD Operation in MongoDb
## Program output for App_POJO.java 
[Create] Total Number of documents in collection: 8 <br />
[Retrieve] Printing documents with Rating greater than 90:  <br />
Movie [Id=5a345c4a5187ea3340d8f3e3, name=Coco, rating=96] <br />
Movie [Id=5a345c4a5187ea3340d8f3e6, name=Thor: Ragnarok, rating=92] <br />
Movie [Id=5a345c4a5187ea3340d8f3e8, name=Lady Bird, rating=100] <br />
Movie [Id=5a345c4a5187ea3340d8f3ea, name=Quest, rating=100] <br />
[Update]: Records modified -1 <br />
[Delete] Total Number of documents after 'deleteOne' operation:  7 <br />
[Delete] Total Number of documents after 'deleteMany' operation:  0 <br />
[Success] Closed connection <br />
 <br /> <br />
## Program output for App.java
[Success] Created connection <br />
[Create] Total Number of documents in collection: 8 <br />
[Retrieve] Printing all documents using find operator: <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead4e" }, "name" : "Coco", "Rating" : 96 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead4f" }, "name" : "Justice League", "Rating" : 40 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead50" }, "name" : "Wonder", "Rating" : 85 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead51" }, "name" : "Thor: Ragnarok", "Rating" : 92 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead52" }, "name" : "Dadd's Home 2", "Rating" : 18 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead53" }, "name" : "Lady Bird", "Rating" : 100 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead54" }, "name" : "The Star", "Rating" : 45 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead55" }, "name" : "Quest", "Rating" : 100 } <br />
[Retrieve] Printing documents with Rating greater than 60:  <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead4e" }, "name" : "Coco", "Rating" : 96 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead50" }, "name" : "Wonder", "Rating" : 85 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead51" }, "name" : "Thor: Ragnarok", "Rating" : 92 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead53" }, "name" : "Lady Bird", "Rating" : 100 } <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead55" }, "name" : "Quest", "Rating" : 100 } <br />
[Update] Printing updating documents:  <br />
{ "_id" : { "$oid" : "5a3075045187ea0bfc7ead50" }, "name" : "Wonder Woman", "Rating" : 85 } <br />
[Delete] Total Number of documents after 'deleteOne' operation:  7 <br />
[Delete] Total Number of documents after 'deleteMany' operation:  0 <br />
[Success] Closed Cursors <br />
[Success] Closed connection <br />

