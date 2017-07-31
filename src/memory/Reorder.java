package memory;

/**
 *
 *  JMM(JAVA内存模型)重排序
 */
public abstract class Reorder {

    /**
     * JMM-重排序概念:编译器和处理器为了提高进程执行时的性能,在保证不破坏程序的语义和执行结果的前提下(注意只保证单核cpu单线程的场景)对指令序列进行重新排列执行顺序.
     */
    public abstract void  concept();

    /**
     * 最终可以进行指令重排序的只有处理器和编译器.
     * 重排序的三种类型(摘录自网上):
     * 1. 编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。
     * 2. 指令级并行的重排序。现代处理器采用了指令级并行技术（Instruction-Level Parallelism， ILP）来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
     * 3. 内存系统的重排序。由于处理器使用缓存和读/写缓冲区,会导致处理器执行程序指令对内存读写的操作与内存实际的读写操作顺序不一致，这使得对内存的加载和存储操作看上去可能是在乱序执行。
     */
    public abstract void  conceptType();

    /**
     * JMM对于重排序的规则: JMM属于语言级的内存模型，它确保在不同的编译器和不同的处理器平台之上(屏蔽不同平台)，通过禁止特定类型的编译器重排序和处理器重排序，为程序员提供一致的内存可见性保证.
     */
    public abstract void conceptRule();

    /**
     * 处理器可见性:是指某个处理器在处理完数据后可以立即刷新到内存中,让其他处理器可以看到最新的结果.因为对于处理器而言缓存,寄存器,缓冲区都是处理器独立的.
     */
    public abstract void cpuVisibility();

    /**
     * jsr-133 happens-before(之前发生):jsr133提出的线程可见性规则,如果一个操作1执行的结果需要对另一个操作2可见，
     * 那么这两个操作之间必须要存在happens-before关系(这里提到的两个操作既可以是在一个线程之内，也可以是在不同线程之间)。即
     * 操作1必须要在操作2之前执行完.
     */
    public abstract void happensBefore();

    /**
     * 数据依赖性:如果两个操作都对同一个变量进行操作,并且其中一个操作为写操作,那么这俩个操作就具有数据依赖性,
     *          编译器和处理器在重排序时，会遵守数据依赖性，编译器和处理器不会改变存在数据依赖性的两个操作
     *          的执行顺序
     * 注意这个数据依赖性只针对单个处理器中单个线程执行的指令序列的操作，不同处理器之间和不同线程之间的数据依赖性不被编译器和处理器考虑
     */
    public abstract void dataDependencies();

}
