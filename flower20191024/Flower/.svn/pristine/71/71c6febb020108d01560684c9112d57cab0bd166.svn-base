package com.flower.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.flower.mapper.ProductDescMapper;
import com.flower.mapper.ProductMapper;
import com.flower.pojo.Product;
import com.flower.pojo.ProductDesc;
import com.flower.util.ObjectMapperUtil;
import com.flower.vo.SysResult;

import redis.clients.jedis.JedisCluster;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductDescMapper productDescMapper;
	@Autowired
	private JedisCluster jedisCluster;
	@Override
	public List<Product> findAll() {
		String jedisJson = jedisCluster.get("com.flower.pojo.Product::findAll");
		if (StringUtils.isEmpty(jedisJson)) {
			List<Product> products = productMapper.findAll();
			String jeson = ObjectMapperUtil.toJESON(products);
			jedisCluster.setex("com.flower.pojo.Product::findAll", 7*24*3600, jeson);
			return products;	
		}
		List<Product> products = ObjectMapperUtil.toObject(jedisJson,List.class);
		System.out.println("调用缓存");
		return products;

	}
	@Override
	@Transactional
	public void inserProduct(Product product,String imgDesc) {
		System.err.println(imgDesc);
		Date date = new Date();
		//自定义商品id
		long id = date.getTime();
		product.setId(id).setCreated(date).setUpdated(date);
		ProductDesc productDesc = new ProductDesc();
		//存入页面信息 和商品信息
		productDesc.setProductId(id).setImgDesc(imgDesc);
		productMapper.insert(product);
		productDescMapper.insert(productDesc);
		jedisCluster.del("com.flower.pojo.Product::findAll");
		System.err.println("删除缓存");
	}
	@Override
	public void deleteByIds(Long[] ids) {
		List<Long> idList = Arrays.asList(ids);
		productMapper.deleteBatchIds(idList);
		jedisCluster.del("com.flower.pojo.Product::findAll");
		System.err.println("删除缓存");
	}
	@Override
	public Product findById(Long id) {
			return productMapper.selectById(id);		
	}
	@Override
	public ProductDesc doFindProductDesc(Long id) {
		ProductDesc productDesc = productDescMapper.selectById(id);
		return productDesc;
	}
	@Override
	@Transactional
	public void doUpdateProduct(Product product, String imgDesc) {
		Long id = product.getId();
		productMapper.updateById(product);
		ProductDesc productDesc = new ProductDesc();
		productDesc.setImgDesc(imgDesc).setProductId(id);
		productDescMapper.updateById(productDesc);
		System.out.println("删除全部列表的缓存");
		jedisCluster.del("com.flower.pojo.Product::findAll");

	}
	@Override
	public List<Product> findList() {
		List<Product> list=productMapper.findList();
		return list;
	}
	@Override
	public List<Product> goodItem() {
		List<Product> list=productMapper.goodItem();
		return list;
	}
}
