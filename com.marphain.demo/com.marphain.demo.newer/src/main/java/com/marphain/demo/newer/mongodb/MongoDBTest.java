package com.marphain.demo.newer.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBTest
{
	public static void main(String[] args)
	{
		String hostName = "localhost";
		int port = 27017;
		String dbName = "test";
		String cName = "test";
		
		MongoClient mongo = null;
		try 
		{
			//连接MongoDB服务器
			mongo = new MongoClient(hostName, port);
			
			//获取数据库实例
			MongoDatabase db = mongo.getDatabase(dbName);
			
			//获取集合（表）
			MongoCollection<Document> collection = db.getCollection(cName);
			
			//插入文档（记录）
			Document document = new Document().append("name", "marphain")
					.append("age", 20)
					.append("sex", 1);
			collection.insertOne(document);
			
			//查询文档信息
			System.out.println("count:" + collection.count());
			System.out.println("document:" + collection.find().first().toJson());
			
			MongoCursor<Document> cursor = collection.find().iterator();
			try 
			{
				while(cursor.hasNext())
				{
					System.out.println(cursor.next());
				}
			} 
			catch (Exception e) 
			{
				cursor.close();
			}
			
			collection.find(Filters.eq("name", "marphain"));
			collection.find(Filters.gt("age", 10));
			
			//删除文档
			collection.deleteOne(Filters.eq("name", "marphain"));
			
		} 
		catch (Exception e) 
		{
			
		}
		finally
		{
			if (mongo != null)
			{
				mongo.close();
			}
		}
	}

}
