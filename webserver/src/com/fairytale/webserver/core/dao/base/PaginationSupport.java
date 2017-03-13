package com.fairytale.webserver.core.dao.base;
import java.util.List;
/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
public class PaginationSupport {

	public final static int PAGESIZE = 10;

    private int pageSize = PAGESIZE;

    private List items;

    private int totalCount;

    private int[] indexes = new int[0];

    private int startIndex = 0;

    public PaginationSupport(List items, int totalCount) {
        setPageSize(PAGESIZE);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(0);
    }

    public PaginationSupport(List items, int totalCount, int startIndex) {
        setPageSize(PAGESIZE);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(startIndex);
    }

    public PaginationSupport(List items, int totalCount, int pageSize, int startIndex) {
        setPageSize(pageSize);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(startIndex);
    }

    /**
     * ��ҳ��ת��Ϊ�б��startIndex��ҳ��СΪĬ�ϴ�С
     */
    public static int convertFromPageToStartIndex(int pageNo) {
        return (pageNo - 1) * PAGESIZE;
    }
    
    /**
     * ��ҳ��ת��Ϊ�б��startIndex
     */
    public static int convertFromPageToStartIndex(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    /**
     * ���������������ҳ��ʼλ��
     */
    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            int count = totalCount / pageSize;
            if (totalCount % pageSize > 0)
                count++;
            indexes = new int[count];
            for (int i = 0; i < count; i++) {
                indexes[i] = pageSize * i;
            }
        } else {
            this.totalCount = 0;
        }
    }

    public int[] getIndexes() {
        return indexes;
    }

    public void setIndexes(int[] indexes) {
        this.indexes = indexes;
    }

    public int getStartIndex() {
        return startIndex;
    }

    /**
     * ���õ�ǰ��ʼλ��
     */
    public void setStartIndex(int startIndex) {
        if (totalCount <= 0)
            this.startIndex = 0;
        else if (startIndex >= totalCount)
            this.startIndex = indexes[indexes.length - 1];
        else if (startIndex < 0)
            this.startIndex = 0;
        else {
            this.startIndex = indexes[startIndex / pageSize];
        }
    }

    /**
     * �����ҳ��ʼλ��
     */
    public int getNextIndex() {
        int nextIndex = getStartIndex() + pageSize;
        if (nextIndex >= totalCount)
            return getStartIndex();
        else
            return nextIndex;
    }

    /**
     * �����ҳ��ʼλ��
     */
    public int getPreviousIndex() {
        int previousIndex = getStartIndex() - pageSize;
        if (previousIndex < 0)
            return 0;
        else
            return previousIndex;
    }

    /**
     * ȡ��ҳ��.
     */
    public long getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    /**
     * ȡ��ҳ��ǰҳ��,ҳ���1��ʼ.
     */
    public long getCurrentPageNo() {
        return startIndex / pageSize + 1;
    }

    /**
     * ��ҳ�Ƿ�����һҳ.
     */
    public boolean hasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount() - 1;
    }

    /**
     * ��ҳ�Ƿ�����һҳ.
     */
    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }
}
