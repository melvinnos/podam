package uk.co.jemos.podam.test.unit.features.typeManufacturing;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.common.PodamConstants;
import uk.co.jemos.podam.test.dto.ClassGenericConstructorPojo;
import uk.co.jemos.podam.test.dto.SimplePojoToTestSetters;
import uk.co.jemos.podam.test.enums.ExternalRatePodamEnum;
import uk.co.jemos.podam.test.unit.AbstractPodamSteps;
import uk.co.jemos.podam.test.unit.steps.PodamFactorySteps;
import uk.co.jemos.podam.typeManufacturers.TypeManufacturerParamsWrapper;
import uk.co.jemos.podam.typeManufacturers.TypeManufacturerParamsWrapperForGenericTypes;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tedonema on 28/06/2015.
 */
@RunWith(SerenityRunner.class)
public class TypeManufacturingTest extends AbstractPodamSteps {

    @BeforeClass
    public static void init() {
        PodamFactorySteps.initPodamFactoryContext();
    }

    @AfterClass
    public static void deinit() {
        PodamFactorySteps.disposePodamFactoryContext();
    }

    private Object produceValueForType(Class<?> pojoType) {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();

        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                (SimplePojoToTestSetters.class);
        podamValidationSteps.theObjectShouldNotBeNull(attributeMetadata);

        TypeManufacturerParamsWrapper paramsWrapper =
                 new TypeManufacturerParamsWrapper(dataProviderStrategy, attributeMetadata);

        return podamInvocationSteps.whenISendAMessageToTheChannel(
                paramsWrapper, pojoType);
    }

    @Test
    @Title("Podam Messaging System should return an int primitive value")
    public void podamMessagingSystemShouldReturnAnIntValue() throws Exception {

        Object payload = produceValueForType(int.class);
        podamValidationSteps.theIntFieldShouldNotBeZero((Integer) payload);
    }

    @Test
    @Title("Podam Messaging System should return an integer value")
    public void podamMessagingSystemShouldReturnAnIntegerValue() throws Exception {

        Object payload = produceValueForType(Integer.class);
        podamValidationSteps.theIntFieldShouldNotBeZero((Integer) payload);
    }

    @Test
    @Title("Podam Messaging System should return a boolean primitive value")
    public void podamMessagingSystemShouldReturnABooleanPrimitiveValue() throws Exception {

        Object payload = produceValueForType(boolean.class);
        podamValidationSteps.theBooleanValueIsTrue((Boolean) payload);
    }

    @Test
    @Title("Podam Messaging System should return a boolean wrapped value")
    public void podamMessagingSystemShouldReturnABooleanWrappedValue() throws Exception {

        Object payload = produceValueForType(Boolean.class);
        podamValidationSteps.theBooleanValueIsTrue((Boolean) payload);
    }

    @Test
    @Title("Podam Messaging System should return a char primitive value")
    public void podamMessagingSystemShouldReturnACharacterPrimitiveValue() throws Exception {

        Object payload = produceValueForType(char.class);
        podamValidationSteps.theObjectShouldNotBeNull((Character) payload);

    }

    @Test
    @Title("Podam Messaging System should return a Character wrapped value")
    public void podamMessagingSystemShouldReturnACharacterWrappedValue() throws Exception {

        Object payload = produceValueForType(Character.class);
        podamValidationSteps.theObjectShouldNotBeNull((Character) payload);
    }

    @Test
    @Title("Podam Messaging System should return a short primitive value")
    public void podamMessagingSystemShouldReturnAShortPrimitiveValue() throws Exception {

        Object payload = produceValueForType(short.class);
        podamValidationSteps.theObjectShouldNotBeNull((Short) payload);
    }

    @Test
    @Title("Podam Messaging System should return a Short wrapped value")
    public void podamMessagingSystemShouldReturnAShortWrappedValue() throws Exception {

        Object payload = produceValueForType(Short.class);
        podamValidationSteps.theObjectShouldNotBeNull((Short) payload);
    }

    @Test
    @Title("Podam Messaging System should return a byte primitive value")
    public void podamMessagingSystemShouldReturnABytePrimitiveValue() throws Exception {

        Object payload = produceValueForType(byte.class);
        podamValidationSteps.theObjectShouldNotBeNull((Byte) payload);
    }

    @Test
    @Title("Podam Messaging System should return a Byte wrapped value")
    public void podamMessagingSystemShouldReturnAByteWrappedValue() throws Exception {

        Object payload = produceValueForType(Byte.class);
        podamValidationSteps.theObjectShouldNotBeNull((Byte) payload);
    }

    @Test
    @Title("Podam Messaging System should return a long primitive value")
    public void podamMessagingSystemShouldReturnALongPrimitiveValue() throws Exception {

        Object payload = produceValueForType(long.class);
        podamValidationSteps.theObjectShouldNotBeNull((Long) payload);
    }

    @Test
    @Title("Podam Messaging System should return a Long wrapped value")
    public void podamMessagingSystemShouldReturnALongWrappedValue() throws Exception {

        Object payload = produceValueForType(Long.class);
        podamValidationSteps.theObjectShouldNotBeNull((Long) payload);
    }

    @Test
    @Title("Podam Messaging System should return a float primitive value")
    public void podamMessagingSystemShouldReturnAFloatPrimitiveValue() throws Exception {

        Object payload = produceValueForType(float.class);
        podamValidationSteps.theObjectShouldNotBeNull((Float) payload);
    }

    @Test
    @Title("Podam Messaging System should return a Float wrapped value")
    public void podamMessagingSystemShouldReturnAFloatWrappedValue() throws Exception {

        Object payload = produceValueForType(Float.class);
        podamValidationSteps.theObjectShouldNotBeNull(payload);
    }

    @Test
    @Title("Podam Messaging System should return a double primitive value")
    public void podamMessagingSystemShouldReturnADoublePrimitiveValue() throws Exception {

        Object payload = produceValueForType(double.class);
        podamValidationSteps.theObjectShouldNotBeNull((Double) payload);
    }

    @Test
    @Title("Podam Messaging System should return a Double wrapped value")
    public void podamMessagingSystemShouldReturnADoubleWrappedValue() throws Exception {

        Object payload = produceValueForType(Double.class);
        podamValidationSteps.theObjectShouldNotBeNull((Double) payload);
    }


    @Test
    @Title("Podam Messaging System should return a String value")
    public void podamMessagingSystemShouldReturnAStringValue() throws Exception {

        Object payload = produceValueForType(String.class);
        podamValidationSteps.theObjectShouldNotBeNull((String) payload);
    }

    @Test
    @Title("Podam Messaging System should return an Enum value")
    public void podamMessagingSystemShouldReturnAnEnumValue() throws Exception {

        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();

        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnAttributeMetadataForEnums
                (ExternalRatePodamEnum.class);
        podamValidationSteps.theObjectShouldNotBeNull(attributeMetadata);

        TypeManufacturerParamsWrapper paramsWrapper =
                new TypeManufacturerParamsWrapper(dataProviderStrategy, attributeMetadata);

        Object payload = podamInvocationSteps.whenISendAMessageToTheChannel(
                paramsWrapper, PodamConstants.ENUMERATION_QUALIFIER);
        podamValidationSteps.theObjectShouldNotBeNull(payload);
    }

    @Test
    @Title("Podam Messaging System should return a Generic Type value")
    public void podamMessagingSystemShouldReturnAGenericTypeValue() throws Exception {

        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();

        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnAttributeMetadataForGenericTypes
                (ClassGenericConstructorPojo.class, Class.class);
        podamValidationSteps.theObjectShouldNotBeNull(attributeMetadata);

        Map<String, Type> genericTypeArgumentsMap = new HashMap<String, Type>();

        genericTypeArgumentsMap.put("T", String.class);

        TypeManufacturerParamsWrapperForGenericTypes paramsWrapper =
                new TypeManufacturerParamsWrapperForGenericTypes(dataProviderStrategy, attributeMetadata,
                        genericTypeArgumentsMap);

        Object payload = podamInvocationSteps.whenISendAMessageToTheChannel(
                paramsWrapper, PodamConstants.GENERIC_TYPE_QUALIFIER);
        podamValidationSteps.theTwoObjectsShouldBeEqual(String.class, payload);
    }



}
