package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    /* renamed from: com.google.gson.internal.ConstructorConstructor$4 */
    class C05394 implements ObjectConstructor<T> {
        C05394() {
        }

        public T construct() {
            return new TreeSet();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$6 */
    class C05416 implements ObjectConstructor<T> {
        C05416() {
        }

        public T construct() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$7 */
    class C05427 implements ObjectConstructor<T> {
        C05427() {
        }

        public T construct() {
            return new LinkedList();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$8 */
    class C05438 implements ObjectConstructor<T> {
        C05438() {
        }

        public T construct() {
            return new ArrayList();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$9 */
    class C05449 implements ObjectConstructor<T> {
        C05449() {
        }

        public T construct() {
            return new TreeMap();
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> instanceCreators) {
        this.instanceCreators = instanceCreators;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<T> typeCreator = (InstanceCreator) this.instanceCreators.get(type);
        if (typeCreator != null) {
            return new ObjectConstructor<T>() {
                public T construct() {
                    return typeCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<T> rawTypeCreator = (InstanceCreator) this.instanceCreators.get(rawType);
        if (rawTypeCreator != null) {
            return new ObjectConstructor<T>() {
                public T construct() {
                    return rawTypeCreator.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> defaultConstructor = newDefaultConstructor(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        ObjectConstructor<T> defaultImplementation = newDefaultImplementationConstructor(type, rawType);
        if (defaultImplementation != null) {
            return defaultImplementation;
        }
        return newUnsafeAllocator(type, rawType);
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> rawType) {
        try {
            final Constructor<? super T> constructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return new ObjectConstructor<T>() {
                public T construct() {
                    try {
                        return constructor.newInstance(null);
                    } catch (InstantiationException e) {
                        throw new RuntimeException("Failed to invoke " + constructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + constructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type type, Class<? super T> rawType) {
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                return new C05394();
            }
            if (EnumSet.class.isAssignableFrom(rawType)) {
                return new ObjectConstructor<T>() {
                    public T construct() {
                        if (type instanceof ParameterizedType) {
                            Type elementType = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (elementType instanceof Class) {
                                return EnumSet.noneOf((Class) elementType);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(rawType)) {
                return new C05416();
            }
            if (Queue.class.isAssignableFrom(rawType)) {
                return new C05427();
            }
            return new C05438();
        } else if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        } else {
            if (SortedMap.class.isAssignableFrom(rawType)) {
                return new C05449();
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new ObjectConstructor<T>() {
                    public T construct() {
                        return new LinkedTreeMap();
                    }
                };
            }
            return new ObjectConstructor<T>() {
                public T construct() {
                    return new LinkedHashMap();
                }
            };
        }
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Type type, final Class<? super T> rawType) {
        return new ObjectConstructor<T>() {
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

            public T construct() {
                try {
                    return this.unsafeAllocator.newInstance(rawType);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
