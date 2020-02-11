package com.mycomp.valuestack;

import com.mycomp.domain.Goods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloAction extends ActionSupport implements ModelDriven<Goods> {
    private Goods goods = new Goods();

    @Override
    public Goods getModel() {
        return goods;
    }

    public String execute() {
        // 获取值栈
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        // 值栈里面的数据分两个区域, 根区和非根区
        // 根区(root): 存放当前action(当前请求)相关的数据
        // 非根区(context): 存放整个程序相关的数据, 比如相关域(request域, session域, application域)

        // 往根区存数据
        Goods myGoods = new Goods();
        myGoods.setName("zzqGoGo");
        myGoods.setPrice(1000.24);
        // 入栈操作
        // valueStack.getRoot().push(myGoods);
        // 可以省略getRoot()
        valueStack.push(myGoods);
        // 把栈顶的元素出栈(从根区中取数据)
        // 可以省略getRoot()
        // Object pop = valueStack.getRoot().po p();
        // Object pop = valueStack.pop();

        // 往域当中写一些信息(往域中存的数据都会被存到非根区中)
        // 往request域
        ActionContext.getContext().put("reqName", "reqValue");
        // 往session域
        ActionContext.getContext().getSession().put("sessionName", "sessionValue");
        // 往application域
        ActionContext.getContext().getApplication().put("appName", "appValue");
        // 以上这些数据, 除了往request域中存的数据, 都会被存放到非根区中相应的域对象里,
        // 往session域中存放的数据被放在了非根区中的session对象里
        // 往application域中存放的数据被放在了非根区中的applicaiton对象里
        // 而往request域中存放的数据直接放在了非根区里面, 没有存放在非根区的request对象里

        System.out.println(this.goods);
        return SUCCESS;
    }

}
