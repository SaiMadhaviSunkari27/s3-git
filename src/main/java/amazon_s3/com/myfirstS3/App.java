package amazon_s3.com.myfirstS3;

import java.io.File;
import java.util.Iterator;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
        /*AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(clientRegion)
                .build();
        		//new AmazonS3Client(credentials);*/
        
    	AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider("default"));
        String bucketName = "team-bucket-east";
       /* if (s3client.doesBucketExist(bucketName))
        {
        	
                    //s3client.deleteObject(bucketName, getKey());
        	s3client.deleteObject(bucketName, "baba.jpg");
        	s3client.deleteBucket(bucketName);
                }*/

        	
        
        CreateBucketRequest request
        = new CreateBucketRequest(bucketName);
        s3client.createBucket(request);
        String fileName = "baba.jpg";
        s3client.putObject(new PutObjectRequest(bucketName, fileName, 
        		new File("C:\\Users\\Vishwanatham\\Desktop\\baba.jpg")).withCannedAcl(CannedAccessControlList.PublicRead));
   
    }   
}
