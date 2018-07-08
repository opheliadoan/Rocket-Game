package Base;//Generics
//Limit to Base.GameObject extension only

import Base.GameObject;

public interface GameObjectAttributes<T extends GameObject> {

    void run (T gameObject);

}
