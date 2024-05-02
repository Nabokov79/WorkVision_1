package ru.nabokovsg.laboratoryNK.model.template;

public enum ColumnHeaderType {

    STRING_NUMBER("№ п.п."),
    DATE("Дата"),
    SURVEYS_TYPE("Выполненное обследование"),
    ORGANIZATION_NAME("Наименование организации"),
    COMPLETED_WORKS("Выполненные работы"),
    DOCUMENT_NUMBER("Номер документа"),
    ELEMENT("Элемент оборудования"),
    DEFECT_ELEMENT("Дефект элемента оборудования"),
    REPAIR_ELEMENT("Выполненный ремонт элемента"),
    VISUAL_INSPECTION("Результаты визуального осмотра"),
    LOCATION_MEASUREMENT("Расположение мест замеров"),
    DESIGN_THICKNESS("Номинальная толщина, мм"),
    MEASURED_THICKNESS("Измеренная толщина, мм"),
    MAX_CORROSION("Максимальная глубина коррозионного повреждения, мм"),
    RESIDUAL_THICKNESS("Остаточная толщина, мм"),
    MIN_ALLOWABLE_THICKNESS("Минимально допустимая толщина, мм"),
    PLACE_NUMBER("№ места измерений"),
    HEIGHT("Высота в месте измерения, мм"),
    DEVIATION("Величина отклонения от горизонтали, мм"),
    PRECIPITATION("Осадка основания за период, мм"),
    DIFFERENCE_NEIGHBORING_POINTS("Разность высот соседних точек, мм"),
    DIFFERENCE_DIAMETRICAL_POINTS("Разность высот диаметрально противоположных точек, мм"),
    DIAMETER_ELEMENT("Диаметр наружный, мм"),
    WALL_THICKNESS("Толщина стенки, мм"),
    HARDNESS("Твердость металла, НВ (среднее значение измерений)");

    public final String label;

    ColumnHeaderType(String label) {
        this.label = label;
    }
}