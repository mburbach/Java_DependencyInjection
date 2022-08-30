package de.mbuframework.injection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * CompAct Injector zum automatisierten initialisieren von Instanzvariabeln.
 */
public final class MegaInjector
{
    private static final Map < String, Object > instanceMap = new HashMap < String, Object >();

    private static final Class < MegaInjection > injectAnnotation = MegaInjection.class;

    private MegaInjector()
    {
    }

    /**
     * initialisiert Felder des übermittelten <i>objects</i> mit der Annotation
     * {@link MegaInjection}
     * 
     * @param object
     */
    public static final void injectFields( final Object object )
    {
        for( Field field : object.getClass().getDeclaredFields() ) {            
            field.setAccessible( true );
            if( field.isAnnotationPresent( injectAnnotation ) ) {
                Class < ? > fieldClass = field.getType();
                Object o;
                if( field.getAnnotation( injectAnnotation ).singleton() ) {
                    o = instanceMap.get( fieldClass.getName() );
                    if( o == null ) {
                        o = createInstance( field.getType() );
                        instanceMap.put( fieldClass.getName(), o );
                    }
                }
                else {
                    o = createInstance( field.getType() );
                }
                try {
                    field.set( object, o );
                }
                catch( IllegalArgumentException e ) {
                    e.printStackTrace();
                }
                catch( IllegalAccessException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Erzeugt neue Instanzen der angegebenen Klasse <i>classType</i>.
     * 
     * @param classType
     * @return
     */
    private static final Object createInstance( Class < ? > classType )
    {
        try {
            return classType.getDeclaredConstructor().newInstance();
        }
        catch( InstantiationException e ) {
            e.printStackTrace();
        }
        catch( IllegalAccessException e ) {
            e.printStackTrace();
        }
        catch( IllegalArgumentException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch( InvocationTargetException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch( NoSuchMethodException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch( SecurityException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
