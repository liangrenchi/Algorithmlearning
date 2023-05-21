## Java基础面试题

### 1、泛形中extends和super的区别

在Java中，泛型中的`extends`和`super`关键字用于限制泛型类型参数的上界和下界。

`extends`关键字用于限制泛型类型参数的上界，表示该类型参数必须是指定类型或其子类型。例如：

```
public class Box<T extends Number> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
}
```

在上面的示例中，泛型类型参数`T`必须是`Number`或其子类型，这样我们就可以在`Box`类中使用`Number`类中的方法，例如`doubleValue()`等。

`super`关键字用于限制泛型类型参数的下界，表示该类型参数必须是指定类型或其父类型。例如：

```
public class Box<T super Integer> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
}
```

在上面的示例中，泛型类型参数`T`必须是`Integer`或其父类型，这样我们就可以在`Box`类中使用`Object`类中的方法，例如`toString()`等。

需要注意的是，`extends`和`super`关键字只能在泛型类型参数声明的时候使用，不能在泛型类型参数使用的地方使用。

总的来说，`extends`和`super`关键字的区别在于，`extends`用于限制泛型类型参数的上界，表示该类型参数必须是指定类型或其子类型，而`super`用于限制泛型类型参数的下界，表示该类型参数必须是指定类型或其父类型。

### 2、描述Java动态代理几种实现方式，分别说出相应优缺点

