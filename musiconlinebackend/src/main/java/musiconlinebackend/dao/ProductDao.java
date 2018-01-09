package musiconlinebackend.dao;

import java.util.List;

import musiconlinebackend.model.Product;

public interface ProductDao 
{
	public void insertProduct(Product product);
	public List<Product>retrieve();
	public Product findById(int pid);
	public List<Product>getProdById(int cid);
	public void deleteProduct(int pid);
	public void update(Product p);
}
