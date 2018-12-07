package com.asiainfo.util;

public class ParamSort implements Comparable<ParamSort>{
	
	
	private Integer num;
    private String val;

    public ParamSort(Integer num, String val) {
		this.num = num;
		this.val = val;
	}

	@Override
	public int compareTo(ParamSort o) {
        if(this.num>o.getNum()){
            return 1;
        }
        else if(this.num<o.getNum()){
            return -1;
        }
        else{
            return 0;
        }
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
