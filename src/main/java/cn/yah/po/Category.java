package cn.yah.po;

public class Category {
    private Integer cid;

    private String name;

    private String var;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var == null ? null : var.trim();
    }
}