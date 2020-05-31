package world.sake.exquakus.doma;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;

@AnnotateWith(annotations = { @Annotation(target = AnnotationTarget.CLASS, type = ApplicationScoped.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Inject.class) })
@Target(ElementType.TYPE)
public @interface DbConfigAware {
}
