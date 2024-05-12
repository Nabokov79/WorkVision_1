package ru.nabokovsg.laboratoryNK.model.template;

public enum ColumnHeaderType {

    STRING_NUMBER("№ п.п."),
    DATE("Дата"),
    SURVEYS_DESCRIPTION("Описание обследования"),
    ORGANIZATION_NAME("Наименование организации"),
    REPAIR_DESCRIPTION("Описание ремонта"),
    DOCUMENT_NUMBER("Номер документа"),
    ELEMENT("Элемент"),
    PART_ELEMENT("Часть элемента"),
    DEFECTS("Дефекты"),
    REPAIR_ELEMENT("Ремонт элемента"),
    VISUAL_INSPECTION("Визуальный осмотр"),
    DESIGN_THICKNESS("Номинальная толщина"),
    MEASURED_THICKNESS("Измеренная толщина"),
    MAX_CORROSION("Глубина коррозионного повреждения"),
    RESIDUAL_THICKNESS("Остаточная толщина"),
    MIN_ALLOWABLE_THICKNESS("Допустимая толщина"),
    PLACE_NUMBER("Номер места измерений(согласно схеме)"),
    HEIGHT("Высота в месте измерения(по реперам, контрольным точкам"),
    DEVIATION("Отклонение от горизонтали"),
    PRECIPITATION("Осадка по реперам"),
    DIFFERENCE_NEIGHBORING_POINTS("Разность высот соседних точек"),
    DIFFERENCE_DIAMETRICAL_POINTS("Разность высот диаметрально противоположных точек"),
    DIAMETER("Диаметр элемента"),
    HARDNESS("Твердость металла");

    public final String label;

    ColumnHeaderType(String label) {
        this.label = label;
    }
}