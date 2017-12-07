package com.takealotreg.form;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {

	public MultipartFile productImage;
        public int productId;
	public String productName;
        public int productPrice;
        public int productQuantity;
        public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
      

	public MultipartFile getFile() {
		return productImage;
	}

	public void setFile(MultipartFile productImage) {
		this.productImage = productImage;
	}

	

}