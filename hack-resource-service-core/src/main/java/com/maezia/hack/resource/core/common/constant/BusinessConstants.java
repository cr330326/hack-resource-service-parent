package com.maezia.hack.resource.core.common.constant;

/**
 * @author : ChenRan
 * @date ： 2023/8/1 18:47
 * Description ：BusinessConstants
 * project ：tgsop-tgsop-service-parent
 * dep : TT-32
 * company: MA
 */
public class BusinessConstants {

    public static final String REQUEST_MEASUREMENTS_ID_RANGE = "range";

    public static final String ELECTRIC_RANGE_KM_NAME = "electricRange_km";

    public static final String REQUEST_ACTION_STATUS_CLIMATISATION = "climatisation";

    public static final String SCENARIO_SNOW_MELTING_NAME = "snowMelting";
    public static final String SCENARIO_SPEED_COOLING_NAME = "speedCooling";
    public static final String SCENARIO_ONE_BUTTON_PREPARATION_NAME = "oneButtonPreparation";

    public static final Double CURRENT_AMBIENT_TEMPERATURE = 3D;

    /**
     * 融雪场景默认规则
     */
    public static final String SCENARIO_SNOW_MELTING_DEFAULT_RULE = "{\n" +
            "    \"targetTemperature\": 30,\n" +
            "    \"targetTemperatureUnit\": \"celsius\",\n" +
            "    \"climatizationAtUnlock\": true,\n" +
            "    \"windowHeatingEnabled\": true\n" +
            "}";

    /**
     * 快速降温场景默认规则
     */
    public static final String SCENARIO_SPEED_COOLING_DEFAULT_RULE = "{\n" +
            "    \"targetTemperature\": 16,\n" +
            "    \"targetTemperatureUnit\": \"celsius\",\n" +
            "    \"climatizationAtUnlock\": true,\n" +
            "    \"windowHeatingEnabled\": false\n" +
            "}";

    /**
     * 一键准备场景默认规则
     */
    public static final String SCENARIO_ONE_BUTTON_PREPARATION_DEFAULT_RULE = "{\n" +
            "    \"targetTemperatureUnit\": \"celsius\",\n" +
            "    \"climatizationAtUnlock\": true,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"minTemperature\": -1000,\n" +
            "            \"maxTemperature\": -10,\n" +
            "            \"targetTemperature\": 28\n" +
            "        },\n" +
            "        {\n" +
            "            \"minTemperature\": -10,\n" +
            "            \"maxTemperature\": 0,\n" +
            "            \"targetTemperature\": 24\n" +
            "        },\n" +
            "        {\n" +
            "            \"minTemperature\": 0,\n" +
            "            \"maxTemperature\": 10,\n" +
            "            \"targetTemperature\": 22\n" +
            "        },\n" +
            "        {\n" +
            "            \"minTemperature\": 10,\n" +
            "            \"maxTemperature\": 30,\n" +
            "            \"targetTemperature\": 21\n" +
            "        }\n" +
            "        {\n" +
            "            \"minTemperature\": 30,\n" +
            "            \"maxTemperature\": 1000,\n" +
            "            \"targetTemperature\": 23\n" +
            "        }\n" +
            "    ]\n" +
            "}";


}
