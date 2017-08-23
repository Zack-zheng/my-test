package com.zzz.basic.thinginginjava.chapters7;

/**
 * Created by jack_ on 2016/10/23.
 */
//: HorrorShow.java
// Extending an interface with inheritance
interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {
    }

    public void destroy() {
    }
}

//extends two  interfaces: DangerousMonster and Lethal
interface Vampire
        extends DangerousMonster, Lethal {
    void drinkBlood();
}

class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    public static void main(String[] args) {
        DragonZilla if2 = new DragonZilla();
        u(if2);
        v(if2);
    }
} ///:~