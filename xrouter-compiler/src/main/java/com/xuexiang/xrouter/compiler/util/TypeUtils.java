package com.xuexiang.xrouter.compiler.util;


import com.xuexiang.xrouter.enums.TypeKind;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import static com.xuexiang.xrouter.compiler.util.Consts.BOOLEAN;
import static com.xuexiang.xrouter.compiler.util.Consts.BYTE;
import static com.xuexiang.xrouter.compiler.util.Consts.DOUBEL;
import static com.xuexiang.xrouter.compiler.util.Consts.FLOAT;
import static com.xuexiang.xrouter.compiler.util.Consts.INTEGER;
import static com.xuexiang.xrouter.compiler.util.Consts.LONG;
import static com.xuexiang.xrouter.compiler.util.Consts.PARCELABLE;
import static com.xuexiang.xrouter.compiler.util.Consts.SHORT;
import static com.xuexiang.xrouter.compiler.util.Consts.STRING;

/**
 * Utils for type exchange
 * @author xuexiang
 * @date 2018/4/2 上午12:06
 */
public class TypeUtils {

    private Types types;
    private Elements elements;
    private TypeMirror parcelableType;

    public TypeUtils(Types types, Elements elements) {
        this.types = types;
        this.elements = elements;

        parcelableType = this.elements.getTypeElement(PARCELABLE).asType();
    }

    /**
     * Diagnostics out the true java type
     *
     * @param element Raw type
     * @return Type class of java
     */
    public int typeExchange(Element element) {
        TypeMirror typeMirror = element.asType();

        // Primitive
        if (typeMirror.getKind().isPrimitive()) {
            return element.asType().getKind().ordinal();
        }

        switch (typeMirror.toString()) {
            case BYTE:
                return TypeKind.BYTE.ordinal();
            case SHORT:
                return TypeKind.SHORT.ordinal();
            case INTEGER:
                return TypeKind.INT.ordinal();
            case LONG:
                return TypeKind.LONG.ordinal();
            case FLOAT:
                return TypeKind.FLOAT.ordinal();
            case DOUBEL:
                return TypeKind.DOUBLE.ordinal();
            case BOOLEAN:
                return TypeKind.BOOLEAN.ordinal();
            case STRING:
                return TypeKind.STRING.ordinal();
            default:    // Other side, maybe the PARCELABLE or OBJECT.
                if (types.isSubtype(typeMirror, parcelableType)) {  // PARCELABLE
                    return TypeKind.PARCELABLE.ordinal();
                } else {    // For others
                    return TypeKind.OBJECT.ordinal();
                }
        }
    }
}