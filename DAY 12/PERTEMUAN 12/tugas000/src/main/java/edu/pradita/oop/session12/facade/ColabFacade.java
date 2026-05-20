package edu.pradita.oop.session12.facade;

/**
 * FACADE PATTERN — One simple entry point to a complex system.
 *
 * PROBLEM:
 * Without Facade, the client must know:
 * - which subsystem classes exist
 * - what order to call them in
 * - how they work together
 *
 * SOLUTION:
 * ColabFacade hides that complexity behind one simple method:
 * startSession()
 *
 * DO: Put orchestration logic here.
 * DO: Keep the client code simple.
 * DONT: Expose unnecessary subsystem complexity to the client.
 */
public class ColabFacade {

    // TODO FA4.1
    // Declare private final fields:
    // gpu (GPU)
    // storage (Storage)
    // kernel (Kernel)
    private final GPU gpu;
    private final Storage storage;
    private final Kernel kernel;

    // TODO FA4.2
    // Initialize all subsystem objects inside the constructor.
    public ColabFacade() {
        this.gpu = new GPU();
        this.storage = new Storage();
        this.kernel = new Kernel();
    }

    // TODO FA4.3
    // Implement startSession().
    //
    // Required order:
    // 1. allocate GPU
    // 2. mount Storage
    // 3. start Kernel
    // 4. print "Cloud session ready"
    public void startSession() {
        gpu.allocate();
        storage.mount();
        kernel.start();
        System.out.println("Cloud session ready");
    }
}