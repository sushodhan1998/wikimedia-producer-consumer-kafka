package com.sush.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wikimedia_recentchange")
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String wikiEventData;

    public WikimediaData(long id, String wikiEventData) {
        this.id = id;
        this.wikiEventData = wikiEventData;
    }

    public WikimediaData() {
    }

    public long getId() {
        return this.id;
    }

    public String getWikiEventData() {
        return this.wikiEventData;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WikimediaData)) return false;
        final WikimediaData other = (WikimediaData) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$wikiEventData = this.getWikiEventData();
        final Object other$wikiEventData = other.getWikiEventData();
        if (this$wikiEventData == null ? other$wikiEventData != null : !this$wikiEventData.equals(other$wikiEventData))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WikimediaData;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $wikiEventData = this.getWikiEventData();
        result = result * PRIME + ($wikiEventData == null ? 43 : $wikiEventData.hashCode());
        return result;
    }

    public String toString() {
        return "WikimediaData(id=" + this.getId() + ", wikiEventData=" + this.getWikiEventData() + ")";
    }
}
