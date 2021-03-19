package com.dnk.swa.service;

import com.dnk.swa.dto.PageDto;

public class PagingService {

	int totalPage;
	int startPage;
	int endPage;
	int startRow;
	int endRow;
	String resultString;
	int nowPage;

	public PagingService(PageDto page, int recordSize, int blockSize, String method) {
	//nowPage 현재페이지
			//totalCount 총 결과값 갯수
			//recordSize 한페이지에 보여줄 row갯수
			//blockSize [1][2] <--이거 갯수
			
			//결과값을 위한 범위값 구하기
			this.startRow = (int) (page.getNowPage() - 1) * recordSize + 1;
			this.endRow = (int) this.startRow + recordSize - 1;
			
			// 총블럭 수 구하기
			this.totalPage = (int)Math.ceil((double)page.getTotalCount() / (double)recordSize);
			
			//[1][2] <-- 이거 시작과 끝 구하기
			this.startPage = (int)((page.getNowPage() -1) / blockSize) * blockSize + 1;
			this.endPage = (int)this.startPage + blockSize - 1;

			//마지막 페이지 번호 보정
			if(this.endPage > this.totalPage) {
				this.endPage = totalPage;
			}
			
			StringBuilder result = new StringBuilder();
			result.append("<form id='form' method='post' class='paging' enctype='application/x-www-form-urlencoded'>");
			result.append("<input type='hidden' name='now_page' id='now_page' value='" + page.getNowPage()  + "' />");
			
			//이전버튼 생성
			if(page.getNowPage() > 1) {
				result.append("<a href='javascript:" + method +"(");
				result.append("1");
				result.append(")' class='pre01' title='FIRST'>");
				result.append("FIRST");
				result.append("</a>");
				
				result.append("<a href='javascript:" + method + "(");
				result.append(page.getNowPage()-1);
				result.append(")' class='pre02' title='PREV'>");
				result.append("PREV");
				result.append("</a>");
			} else {
				result.append("<a href='javascript:void(0);' title='FIRST' class='pre_end preEnNon'>");
				result.append("FIRST");
				result.append("</a>");
				
				result.append("<a href='javascript:void(0);' title='PREV' class='pre preNon'>");
				result.append("PREV");
				result.append("</a>");
			}
			
			if(endPage == 0) {
				result.append("<strong>1</strong>");
			} else {
				for(int i=startPage; i<=endPage; i++) {
					if(page.getNowPage() == i) {
						result.append("<strong>");
						result.append(i);
						result.append("</strong>");
					} else {
						result.append("<a href='javascript:" + method + "(");
						result.append(i);
						result.append(")' title='" + i + "'> ");
						result.append(i);
						result.append(" </a>");
					}
				}
			}
			
			if(page.getNowPage() < totalPage) {
				result.append("<a href='javascript:" + method + "(");
				result.append(page.getNowPage() + 1);
				result.append(")' class='next' title='NEXT' >");
				result.append("NEXT");
				result.append("</a>");

				//끝 페이지
				result.append("<a href='javascript:" + method + "(");
				result.append(totalPage);
				result.append(")' class='next_end' title='LAST'>");
				result.append("LAST");
				result.append("</a>");
			} else {
				result.append("<a href='javascript:void(0);' title='NEXT' class='next'>");
				result.append("NEXT");
				result.append("</a>");

				//끝 페이지
				result.append("<a href='javascript:void(0);' title='LAST' class='next_end'>");
				result.append("LAST");
				result.append("</a>");
			}
			
			result.append("</form>");
			resultString = result.toString();
			
		}

		public String resultString() {
			return resultString;
		}
		
		public int getStartRow() {
			return startRow;
		}

		public int getEndRow() {
			return endRow;
		}
		
		public int getTotalPage() {
			return totalPage;
		}	
		
		public int getNowPage() {
			return nowPage;
		}
}
