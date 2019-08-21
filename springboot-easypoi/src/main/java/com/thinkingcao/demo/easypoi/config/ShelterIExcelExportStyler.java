package com.thinkingcao.demo.easypoi.config;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;

/**
 * 修改自定义样式：
 */
public class ShelterIExcelExportStyler extends ExcelExportStylerDefaultImpl implements IExcelExportStyler {

	public ShelterIExcelExportStyler(Workbook workbook) {
		super(workbook);
	}

	@Override
	public CellStyle getTitleStyle(short color) {
		CellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		titleStyle.setWrapText(true);
		return titleStyle;
	}

	@Override
	public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp) {
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setDataFormat(STRING_FORMAT);
		if (isWarp) {
			style.setWrapText(true);
		}
		return style;
	}

	@Override
	public CellStyle getHeaderStyle(short color) {
		CellStyle titleStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 20);
		titleStyle.setFont(font);
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		return titleStyle;
	}

	@Override
	public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp) {
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
//        font.setFontHeightInPoints((short) 15);
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setDataFormat(STRING_FORMAT);

		if (isWarp) {
			style.setWrapText(true);
		}
		return style;
	}

}
