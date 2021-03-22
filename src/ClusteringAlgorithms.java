package sauer24j.clustering;

import java.io.File;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.FarthestFirst;
import net.sf.javaml.clustering.AQBC;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;
import java.io.IOException;

public class ClusteringAlgorithms
{
    public static void main(String[] args) throws Exception
    {
	ClusteringAlgorithms test = new ClusteringAlgorithms();
	test.KMeansClustering();
	test.AQBCClustering();
	test.FarthestFirstClustering();

	return;
    }

    public void KMeansClustering()
    {
	Dataset data;
	
	try
	    {
		data = FileHandler.loadDataset(new File("data/iris.data"), 4, ",");
	    }
	catch (IOException e)
	    {
		e.printStackTrace();
		return;
	    }
	
	Clusterer km = new KMeans();

	Dataset[] clusters = km.cluster(data);
	System.out.println("Cluster count; " + clusters.length);
    }

    public void AQBCClustering()
    {
	Dataset data;
	
        try
	    {
		data = FileHandler.loadDataset(new File("data/iris.data"), 4, ",");
	    }
	catch (IOException e)
	    {
		e.printStackTrace();
		return;
	    }

	Clusterer aqbc = new AQBC();

	Dataset[] clusters = aqbc.cluster(data);
	System.out.println("Cluster count; " + clusters.length);
    }

    public void FarthestFirstClustering()
    {
	Dataset data;
	
        try
	    {
		data = FileHandler.loadDataset(new File("data/iris.data"), 4, ",");
	    }
	catch (IOException e)
	    {
		e.printStackTrace();
		return;
	    }

	Clusterer ff = new FarthestFirst();

	Dataset[] clusters = ff.cluster(data);
	System.out.println("Cluster count; " + clusters.length);
    }
}
